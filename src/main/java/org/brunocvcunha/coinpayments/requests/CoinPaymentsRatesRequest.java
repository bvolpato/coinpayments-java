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
package org.brunocvcunha.coinpayments.requests;

***REMOVED***

***REMOVED***
***REMOVED***
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

***REMOVED***
***REMOVED*** Search GIFs Request
***REMOVED*** 
***REMOVED*** @author Bruno Candido Volpato da Cunha
***REMOVED***
***REMOVED***/
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CoinPaymentsRatesRequest extends CoinPaymentsPostRequest<ResponseWrapper<Map<String, RateResponse>>> {

    private boolean onlyAccepted = true;
    
    @Override
    public String getUrl() {
        return "";
***REMOVED***
    
    @Override
    @SneakyThrows
    public String getPayload() {
        return "cmd=rates&accepted=" + (onlyAccepted ? "1" : "0");
***REMOVED***


    @Override
    @SneakyThrows
    public ResponseWrapper<Map<String, RateResponse>> parseResult(int statusCode, String content) {
        ResponseWrapper<Map<String, RateResponse>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<Map<String, RateResponse>>>() {***REMOVED***);
        return wrapper;
***REMOVED***

***REMOVED***
