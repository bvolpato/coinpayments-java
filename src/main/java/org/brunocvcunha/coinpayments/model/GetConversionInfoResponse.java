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
package org.brunocvcunha.coinpayments.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetConversionInfoResponse {

    @JsonProperty("time_created")
    private long timeCreated;
    
    private int status;

    @JsonProperty("status_text")
    private String statusText;
    
    private String coin1;

    private String coin2;
    
    @JsonProperty("amount_sent")
    private BigInteger amountSent;
    
    @JsonProperty("amount_sentf")
    private double amountSentf;
    
    private BigInteger received;
    
    private double receivedf;
}