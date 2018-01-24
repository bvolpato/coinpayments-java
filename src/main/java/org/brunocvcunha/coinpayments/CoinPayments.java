***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED*** Licensed under the Apache License, Version 2.0 (the "License");
***REMOVED*** you may not use this file except in compliance with the License.
***REMOVED*** You may obtain a copy of the License at
***REMOVED***
***REMOVED***         http://www.apache.org/licenses/LICENSE-2.0
***REMOVED***
***REMOVED*** Unless required by applicable law or agreed to in writing, software
***REMOVED*** distributed under the License is distributed on an "AS IS" BASIS,
***REMOVED*** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
***REMOVED*** See the License for the specific language governing permissions and
***REMOVED*** limitations under the License.
***REMOVED***/
***REMOVED***

***REMOVED***

import org.apache.http.HttpResponse;
***REMOVED***
import org.apache.http.impl.client.CloseableHttpClient;
***REMOVED***
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

***REMOVED***
***REMOVED*** 
***REMOVED*** CoinPayments API
***REMOVED*** 
***REMOVED*** @author Bruno Candido Volpato da Cunha
***REMOVED***
***REMOVED***/
@Builder
@Log4j
public class CoinPayments {

    @Getter
    @Setter
    private String publicKey;
    
    @Getter
    @Setter
    private String privateKey;

    @Getter
    @Setter
    protected HttpResponse lastResponse;

    @Getter
    @Setter
    protected CloseableHttpClient client;

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** Send request to endpoint
  ***REMOVED*****REMOVED*****REMOVED*** 
  ***REMOVED*****REMOVED*****REMOVED*** @param request
  ***REMOVED*****REMOVED*****REMOVED***            Request object
  ***REMOVED*****REMOVED*****REMOVED*** @return success flag
  ***REMOVED*****REMOVED*****REMOVED*** @throws IOException
  ***REMOVED*****REMOVED*****REMOVED*** @throws ClientProtocolException
  ***REMOVED*****REMOVED*****REMOVED***/
    public <T> T sendRequest(CoinPaymentsRequest<T> request) throws ClientProtocolException, IOException {

        log.info("Sending request: " + request.getClass().getName());

        request.setApi(this);
        T response = request.execute();

        log.info("Result for " + request.getClass().getName() + ": " + response);

        return response;
***REMOVED***


***REMOVED***