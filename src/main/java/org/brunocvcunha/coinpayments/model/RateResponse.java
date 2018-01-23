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
public class RateResponse {
    private String name;
    
    @JsonProperty("is_fiat")
    private String fiat;
    
    @JsonProperty("rate_btc")
    private String rateBtc;
    
    @JsonProperty("last_update")
    private long last_update;
    
    private int confirms;
    
***REMOVED***