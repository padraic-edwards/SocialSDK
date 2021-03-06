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
package com.ibm.sbt.services.client.connections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.sbt.services.client.connections.activities.ActivityAddMembers;
import com.ibm.sbt.services.client.connections.activities.ActivityDescendantsSinceTest;
import com.ibm.sbt.services.client.connections.activities.ActivityDescendantsSortByTest;
import com.ibm.sbt.services.client.connections.activities.ActivityFeedMoveTest;
import com.ibm.sbt.services.client.connections.activities.ActivityLargeContentTest;
import com.ibm.sbt.services.client.connections.activities.ActivityLargeFieldTest;
import com.ibm.sbt.services.client.connections.activities.ActivityMoveFieldTest;
import com.ibm.sbt.services.client.connections.activities.ActivityNodeChildrenSinceTest;
import com.ibm.sbt.services.client.connections.activities.ActivityReadNoTagsTest;
import com.ibm.sbt.services.client.connections.activities.CreateActivityPerformanceTest;
import com.ibm.sbt.services.client.connections.activities.GetActivityReplyNodeTagsTest;
import com.ibm.sbt.services.client.connections.activities.MakeActivityPublicTest;

/**
 * @author mwallace
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	ActivityDescendantsSinceTest.class,
	ActivityNodeChildrenSinceTest.class,
	ActivityDescendantsSortByTest.class,
	ActivityMoveFieldTest.class,
	ActivityFeedMoveTest.class,
	MakeActivityPublicTest.class,
	GetActivityReplyNodeTagsTest.class,
	ActivityAddMembers.class,
	CreateActivityPerformanceTest.class,
	ActivityLargeContentTest.class,
	ActivityReadNoTagsTest.class,
	ActivityLargeFieldTest.class
})
public class ActivitiesEnhTestSuite {
}
