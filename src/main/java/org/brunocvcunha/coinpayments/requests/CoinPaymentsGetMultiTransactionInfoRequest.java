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

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.model.TransactionDetailsResponse;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsGetMultiTransactionInfoRequest extends CoinPaymentsPostRequest<ResponseWrapper<List<TransactionDetailsResponse>>> {
	
	private List<String> txid = Arrays.asList(new String[25]);

	@Override
	public String getUrl() {
        return "";
	}
	
    @Override
    @SneakyThrows
    public String getPayload() {
    	String p = String.join("|", txid);
        return "cmd=get_tx_info_multi&txid=" + p + "&full=1";
    }

	@Override
	public ResponseWrapper<List<TransactionDetailsResponse>> parseResult(int resultCode, String content) throws JsonProcessingException {
        ResponseWrapper<List<TransactionDetailsResponse>> wrapper = parseJson(content,
                new TypeReference<ResponseWrapper<List<TransactionDetailsResponse>>>() {
                });
        return wrapper;
	}

}
