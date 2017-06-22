


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gydo194
 */

  package Evo2;

import java.util.HashMap;
  import java.util.concurrent.Callable;
  public class ExecuteOnRequest extends HttpResponse {
        String subProcess = null;
        HashMap<String,String> params = new HashMap<String,String>();
        public ExecuteOnRequest(String listenURL, String initialReturnData, int status, String shellCommand) {
            super(listenURL, initialReturnData, status);
            //System.out.println("Creating CallBackClass.");
            subProcess = shellCommand;
            
        }
        
        
        public void setParamMap(HashMap<String,String> map ) {
            params = map;
        }
        
        
        
        @Override
        public String getResponse() {
            if(subProcess != null) {
                try {
                    String sessionSubProcess = subProcess;
                    if( sessionSubProcess.contains("%r") || params.containsKey("r") ) {
                        sessionSubProcess = subProcess.replaceAll("%r", params.get("r"));
                    }
                    System.out.println("sessionSubProcess = " + sessionSubProcess);
                    System.out.println("Running sub process.");
                    Runtime.getRuntime().exec(sessionSubProcess);
                    
                    
                } catch (Exception e) {
                    System.out.println("Exception in Call-Back:");
                } 
                //subProcess = "/usr/bin/say 'not reset'";
            }
            else {
                System.out.println("CallScriptOnCallBack: Error: Call Back is null");
            }
            //return super.getResponse();
            return "HTTP/1.1 200\nServer: Evo2\nCache-Control: No-Cache\n\nparam r:"+params.get("r");
        }
    }