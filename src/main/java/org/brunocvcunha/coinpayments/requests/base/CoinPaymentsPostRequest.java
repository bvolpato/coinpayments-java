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
package org.brunocvcunha.coinpayments.requests.base;

***REMOVED***

import javax.crypto.Mac;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.http.HttpResponse;
***REMOVED***
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.brunocvcunha.coinpayments.CoinPaymentsConstants;

import lombok.extern.log4j.Log4j;

***REMOVED***
***REMOVED*** 
***REMOVED*** @author brunovolpato
***REMOVED***
***REMOVED***/
@Log4j
public abstract class CoinPaymentsPostRequest<T> extends CoinPaymentsRequest<T> {

    @Override
    public String getMethod() {
        return "POST";
***REMOVED***
    
    @Override
    public T execute() throws ClientProtocolException, IOException {
        HttpPost post = new HttpPost(CoinPaymentsConstants.API_URL + getUrl());
        post.addHeader("Connection", "close");
        post.addHeader("Accept", "*/*");
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.addHeader("Cookie2", "$Version=1");
        post.addHeader("Accept-Language", "en-US");
        
        String payload = getPayload();
        log.info("Base Payload: " + payload);
        
        payload += "&version=1&key=" + api.getPublicKey() + "&format=json";
        
        String hmac = HmacUtils.hmacSha512Hex(api.getPrivateKey(), payload);
        log.info("HMAC: " + hmac);
        
        post.addHeader("HMAC", hmac);
        
        log.info("Final Payload: " + payload);
        post.setEntity(new StringEntity(payload));
        
        HttpResponse response = api.getClient().execute(post);
        api.setLastResponse(response);
        
        int resultCode = response.getStatusLine().getStatusCode();
        String content = EntityUtils.toString(response.getEntity());
        
        post.releaseConnection();

        return parseResult(resultCode, content);
***REMOVED***

    public boolean isSigned() {
        return true;
***REMOVED***
***REMOVED***
