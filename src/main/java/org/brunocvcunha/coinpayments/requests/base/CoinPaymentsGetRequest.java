***REMOVED***
***REMOVED*** Copyright (C) 2017 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
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

import org.apache.http.HttpResponse;
***REMOVED***
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.brunocvcunha.coinpayments.CoinPaymentsConstants;

***REMOVED***
***REMOVED*** Base for GET requests
***REMOVED*** 
***REMOVED*** @author Bruno Candido Volpato da Cunha
***REMOVED***
***REMOVED***/
public abstract class CoinPaymentsGetRequest<T> extends CoinPaymentsRequest<T> {

    @Override
    public String getMethod() {
        return "GET";
***REMOVED***

    @Override
    public T execute() throws ClientProtocolException, IOException {
        HttpGet get = new HttpGet(CoinPaymentsConstants.API_URL + getUrl());
        get.addHeader("Connection", "close");
        get.addHeader("Accept", "*/*");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");
        get.addHeader("Accept-Language", "en-US");

        HttpResponse response = api.getClient().execute(get);
        api.setLastResponse(response);

        int resultCode = response.getStatusLine().getStatusCode();
        String content = EntityUtils.toString(response.getEntity());

        get.releaseConnection();

        return parseResult(resultCode, content);
***REMOVED***

    @Override
    public String getPayload() {
        return null;
***REMOVED***

***REMOVED***
