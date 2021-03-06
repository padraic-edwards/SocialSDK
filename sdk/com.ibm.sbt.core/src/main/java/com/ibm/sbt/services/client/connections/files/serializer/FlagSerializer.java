/*
 * © Copyright IBM Corp. 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */

package com.ibm.sbt.services.client.connections.files.serializer;

import static com.ibm.sbt.services.client.base.ConnectionsConstants.CONTENT;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.ENTRY;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.IN_REF_TO;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.REF;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.REF_ITEM_TYPE;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.REL;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.TEXT;
import static com.ibm.sbt.services.client.base.ConnectionsConstants.TYPE;
import static com.ibm.sbt.services.client.connections.files.FileConstants.REPORT_ITEM;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import com.ibm.sbt.services.client.base.ConnectionsConstants.Namespace;
import com.ibm.sbt.services.client.base.serializers.XmlSerializer;
import com.ibm.sbt.services.client.connections.files.FileConstants.ItemType;

/**
 * 
 * @author Lorenzo Boccaccia
 * 
 */
public class FlagSerializer extends XmlSerializer {

    private String   id;
    private String   reason;
    private ItemType what;

    public FlagSerializer(String objectId, String flagReason, ItemType flagWhat) {
        this.id = objectId;
        this.reason = flagReason;
        this.what = flagWhat;
    }

    private void generateFlagPayload() {
        Node entry = entry();
        appendChildren(entry,
                inRefTo(),
                reason());
    }

    public String flagPayload() {
        generateFlagPayload();
        return serializeToString();
    }

    private Node entry() {
        Element element = element(Namespace.ATOM.getUrl(), ENTRY);
        element.setAttributeNS(Namespace.XMLNS.getUrl(), Namespace.SNX.getNSPrefix(), Namespace.SNX.getUrl());
        Node root = rootNode(element);
        return root;
    }

    private Element reason() {
        Element element = textElement(CONTENT, reason,
                attribute(TYPE, TEXT));
        return element;
    }

    private Element inRefTo() {
        Element element = element(Namespace.SNX.getUrl(), IN_REF_TO,
                attribute(REL, REPORT_ITEM),
                attribute(REF, id),
                attribute(REF_ITEM_TYPE, getItemType())
                );
        return element;
    }

    private String getItemType() {
        switch (what) {
            case COMMENT:
                return "comment";
            default:
                return "document";
        }
    }

}
