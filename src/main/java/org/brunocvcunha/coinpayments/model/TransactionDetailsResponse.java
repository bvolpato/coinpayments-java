/**
 * Copyright (C) 2017 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
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
package org.brunocvcunha.coinpayments.model;

import java.math.BigInteger;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Search Result
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetailsResponse {

    @JsonProperty("time_created")
    private long timeCreated;

    @JsonProperty("time_expires")
    private long timeExpires;
    
    private int status;

    @JsonProperty("status_text")
    private String statusText;
    
    private String type;
    
    private String coin;
    
    private BigInteger amount;
    
    private double amountf;
    
    private BigInteger received;
    
    private double receivedf;

    @JsonProperty("recv_confirms")
    private int confirmations;
    
    @JsonProperty("payment_address")
    private String paymentAddress;
    
    private Map<String, Object> checkout;

}