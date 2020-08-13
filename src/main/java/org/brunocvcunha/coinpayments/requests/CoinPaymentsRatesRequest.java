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
package org.brunocvcunha.coinpayments.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.brunocvcunha.coinpayments.model.RateResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import java.util.Map;

/**
 * Search GIFs Request
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsRatesRequest extends CoinPaymentsPostRequest<ResponseWrapper<Map<String, RateResponse>>> {

    private boolean onlyAccepted = true;
    
    private boolean onlyShort = false;

    @Override
    public String getUrl() {
        return "";
    }
    
    @Override
    public String getPayload() {
        return "cmd=rates&accepted=" + (onlyAccepted ? "1" : "0") + "&short=" + (onlyShort ? "1" : "0");
    }


    @Override
    public ResponseWrapper<Map<String, RateResponse>> parseResult(int statusCode, String content) throws JsonProcessingException {
        ResponseWrapper<Map<String, RateResponse>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<Map<String, RateResponse>>>() {});
        return wrapper;
    }

}
