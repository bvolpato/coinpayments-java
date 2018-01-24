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

import org.brunocvcunha.coinpayments.model.BasicInfoResponse;
import org.brunocvcunha.coinpayments.model.RateResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * Search GIFs Request
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@RequiredArgsConstructor
public class CoinPaymentsBasicAccountInfoRequest extends CoinPaymentsPostRequest<ResponseWrapper<BasicInfoResponse>> {

    @Override
    public String getUrl() {
        return "";
    }
    
    @Override
    @SneakyThrows
    public String getPayload() {
        return "cmd=get_basic_info";
    }


    @Override
    @SneakyThrows
    public ResponseWrapper<BasicInfoResponse> parseResult(int statusCode, String content) {
        ResponseWrapper<BasicInfoResponse> wrapper = parseJson(content, new TypeReference<ResponseWrapper<BasicInfoResponse>>() {});

        //ResponseWrapper<BasicInfoResponse> wrapper = parseJson(content, ResponseWrapper.class);
        //wrapper.setResult(parseJson(new ObjectMapper().writeValueAsString(wrapper.getResult()), BasicInfoResponse.class)); //?j
        return wrapper;
    }

}
