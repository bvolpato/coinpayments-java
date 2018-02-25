/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments.requests.base;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.brunocvcunha.coinpayments.CoinPaymentsConstants;

/**
 * Base for GET requests
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public abstract class CoinPaymentsGetRequest<T> extends CoinPaymentsRequest<T> {

    @Override
    public String getMethod() {
        return "GET";
    }

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
    }

    @Override
    public String getPayload() {
        return null;
    }

}
