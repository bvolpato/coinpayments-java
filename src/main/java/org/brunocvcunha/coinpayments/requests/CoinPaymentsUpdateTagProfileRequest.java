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
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.model.UpdateTagProfileResponse;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsUpdateTagProfileRequest extends CoinPaymentsPostRequest<ResponseWrapper<List<UpdateTagProfileResponse>>> {
	
	@NonNull
	private String tagId;
	
	@Builder.Default private String name = "";
	
	@Builder.Default private String email = "";
	
	@Builder.Default private String url = "";
	
	@Builder.Default private String image = "";

	@Override
	public String getUrl() {
		return "";
	}
	
    @Override
    public String getPayload() {
    	String p = !name.isEmpty() ? "&name=" + name : "";
    	p = !email.isEmpty() ? "&email=" + email : p;
    	p = !url.isEmpty() ? "&url=" + url : p;
    	p = !image.isEmpty() ? "&image=" + image : p;
        return "cmd=update_pbn_tag" + "&tagid=" + tagId + p;
    }

	@Override
	public ResponseWrapper<List<UpdateTagProfileResponse>> parseResult(int resultCode, String content) throws JsonProcessingException {
        ResponseWrapper<List<UpdateTagProfileResponse>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<List<UpdateTagProfileResponse>>>() {});
        return wrapper;
	}

}
