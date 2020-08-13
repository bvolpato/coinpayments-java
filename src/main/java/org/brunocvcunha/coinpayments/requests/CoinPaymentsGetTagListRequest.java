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

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.brunocvcunha.coinpayments.model.GetTagListResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class CoinPaymentsGetTagListRequest extends CoinPaymentsPostRequest<ResponseWrapper<List<GetTagListResponse>>> {

	@Override
	public String getUrl() {
		return "";
	}
	
    @Override
    public String getPayload() {
        return "cmd=get_pbn_list";
    }

	@Override
	public ResponseWrapper<List<GetTagListResponse>> parseResult(int resultCode, String content) throws JsonProcessingException {
        ResponseWrapper<List<GetTagListResponse>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<List<GetTagListResponse>>>() {});
        return wrapper;		
	}

}
