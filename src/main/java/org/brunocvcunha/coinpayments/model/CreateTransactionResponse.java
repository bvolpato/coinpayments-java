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
package org.brunocvcunha.coinpayments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

***REMOVED***
***REMOVED*** Search Result
***REMOVED*** 
***REMOVED*** @author Bruno Candido Volpato da Cunha
***REMOVED***
***REMOVED***/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTransactionResponse {
    private double amount;
    private String address;

    @JsonProperty("txn_id")
    private String transactionId;

    @JsonProperty("confirms_needed")
    private int confirmsNeeded;

    private long timeout;
    @JsonProperty("status_url")
    private String statusUrl;

    @JsonProperty("qrcode_url")
    private String qrcodeUrl;

***REMOVED***