package com.smartdevicelink.proxy.rpc;

import java.util.Hashtable;
import java.util.List;

import com.smartdevicelink.protocol.enums.FunctionID;
import com.smartdevicelink.proxy.RPCResponse;

/**
 * Get DTCs Response is sent, when GetDTCs has been called
 * 
 * @since SmartDeviceLink 2.0
 */
public class GetDTCsResponse extends RPCResponse{

    public static final String KEY_ECU_HEADER = "ecuHeader";
    public static final String KEY_DTC = "dtc";

    public GetDTCsResponse(){
        super(FunctionID.GET_DTCS);
    }

    public GetDTCsResponse(Hashtable<String, Object> hash){
        super(hash);
    }

    @SuppressWarnings("unchecked")
    public List<String> getDtc(){
        if(parameters.get(KEY_DTC) instanceof List<?>){
            List<?> list = (List<?>) parameters.get(KEY_DTC);
            if(list != null && list.size() > 0){
            	for( Object obj : list ) {
        			if (!(obj instanceof String)) {
        				return null;
        			}
        		}
        		return (List<String>) list;
            }
        }
        return null;
    }

    public void setDtc(List<String> dtc){

    	boolean valid = true;
    	
    	for ( String item : dtc ) {
    		if (item == null) {
    			valid = false;
    		}
    	}
    	
    	if ( (dtc != null) && (dtc.size() > 0) && valid) {
            parameters.put(KEY_DTC, dtc);
        }
        else{
            parameters.remove(KEY_DTC);
        }
    }
    
    public Integer getEcuHeader(){
        return (Integer) parameters.get(KEY_ECU_HEADER);
    }
    
    public void setEcuHeader(Integer ecuHeader){
        if(ecuHeader != null){
            parameters.put(KEY_ECU_HEADER, ecuHeader);
        }
        else{
            parameters.remove(KEY_ECU_HEADER);
        }
    }
}
