/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.api.cluster.impl;

import org.bubblecloud.zigbee.api.ZigBeeDeviceException;
import org.bubblecloud.zigbee.api.cluster.general.FlowMeasurement;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.Attribute;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.Reporter;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.ZigBeeClusterException;
import org.bubblecloud.zigbee.api.cluster.impl.general.FlowMeasurementCluster;
import org.bubblecloud.zigbee.network.ZigBeeEndpoint;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision:  $ ($LastChangedDate: $)
 *
 */
public class FlowMeasurementImpl implements FlowMeasurement {
	
	private FlowMeasurementCluster flowMeasurementCluster;


	public FlowMeasurementImpl(ZigBeeEndpoint zbDevice){
		flowMeasurementCluster = new FlowMeasurementCluster(zbDevice);
		
	}

	public int getId() {
		
		return flowMeasurementCluster.getId();
	}

	public String getName() {
	
		return flowMeasurementCluster.getName();
	}

    public Reporter[] getAttributeReporters() {
		return flowMeasurementCluster.getAttributeReporters();
	}

	public Attribute[] getAttributes() {
	
		return flowMeasurementCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = flowMeasurementCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if( attributes[i].getId() == id ) 
				return attributes[i];
		}
		return null;
	}

	public String getDescription() throws ZigBeeDeviceException {
		 try {
	            return (String) flowMeasurementCluster.getAttributeDescription().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeDeviceException(e);
	        }
	}




}