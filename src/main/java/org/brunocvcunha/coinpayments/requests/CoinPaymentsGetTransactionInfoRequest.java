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
package org.brunocvcunha.coinpayments.requests;

***REMOVED***
***REMOVED***
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

***REMOVED***
***REMOVED*** CoinPaymentsCreateTransactionRequest
***REMOVED*** 
***REMOVED*** @author Bruno Candido Volpato da Cunha
***REMOVED***
***REMOVED***/
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CoinPaymentsGetTransactionInfoRequest
        extends CoinPaymentsPostRequest<ResponseWrapper<TransactionDetailsResponse>> {

    private String txid;

    @Override
    public String getUrl() {
        return "";
***REMOVED***

    @Override
    @SneakyThrows
    public String getPayload() {
        return "cmd=get_tx_info&txid=" + txid + "&full=1";
***REMOVED***

    @Override
    @SneakyThrows
    public ResponseWrapper<TransactionDetailsResponse> parseResult(int statusCode, String content) {
        ResponseWrapper<TransactionDetailsResponse> wrapper = parseJson(content,
                new TypeReference<ResponseWrapper<TransactionDetailsResponse>>() {
    ***REMOVED***);
        return wrapper;
***REMOVED***

***REMOVED***
