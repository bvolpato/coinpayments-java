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
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
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
@Builder
public class CoinPaymentsCreateTransactionRequest
        extends CoinPaymentsPostRequest<ResponseWrapper<CreateTransactionResponse>> {

    @NonNull
    private double amount;

    @NonNull
    private String currencyPrice;

    @NonNull
    private String currencyTransfer;

    @Builder.Default private String address = "";

    @Builder.Default private String buyerEmail = "";
    @Builder.Default private String buyerName = "";
    @Builder.Default private String itemName = "";
    @Builder.Default private String itemCode = "";
    @Builder.Default private String invoice = "";
    @Builder.Default private String custom = "";
    @Builder.Default private String callbackUrl = "";

    @Override
    public String getUrl() {
        return "";
***REMOVED***

    @Override
    @SneakyThrows
    public String getPayload() {
        return "cmd=create_transaction" + "&amount=" + amount + "" + "&currency1=" + currencyPrice + "&currency2="
                + currencyTransfer + "&address=" + address + "&buyer_email=" + buyerEmail + "&buyer_name=" + buyerName
                + "&item_name=" + itemName + "&item_number=" + itemCode + "&invoice=" + invoice + "&custom=" + custom
                + "&ipn_url=" + callbackUrl;
***REMOVED***

    @Override
    @SneakyThrows
    public ResponseWrapper<CreateTransactionResponse> parseResult(int statusCode, String content) {
        ResponseWrapper<CreateTransactionResponse> wrapper = parseJson(content,
                new TypeReference<ResponseWrapper<CreateTransactionResponse>>() {
    ***REMOVED***);
        return wrapper;
***REMOVED***

***REMOVED***
