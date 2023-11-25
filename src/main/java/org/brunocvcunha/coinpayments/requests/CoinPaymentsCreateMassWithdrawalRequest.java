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
import lombok.*;

import java.util.List;
import java.util.Map;

import org.brunocvcunha.coinpayments.model.CreateWithdrawalResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

@RequiredArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CoinPaymentsCreateMassWithdrawalRequest extends CoinPaymentsPostRequest<ResponseWrapper<Map<String, CreateWithdrawalResponse>>> {

    @NonNull
    private List<Map<String, String>> wd;

    @Override
    public String getUrl () {
        return "";
    }

    @Override
    public String getPayload () {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wd.size(); i++){
            Map<String, String> entries = wd.get(i);
            for(Map.Entry<String, String> entry : entries.entrySet()) {
                sb.append("&wd[wd").append(i).append("][").append(entry.getKey()).append("]").append("=").append(entry.getValue());
            }
        }
        return "cmd=create_mass_withdrawal" + sb.toString();
    }

    @Override
    public ResponseWrapper<Map<String, CreateWithdrawalResponse>> parseResult ( int resultCode, String content ) throws JsonProcessingException {
    	ResponseWrapper<Map<String, CreateWithdrawalResponse>> wrapper = parseJson( content, new TypeReference<ResponseWrapper<Map<String, CreateWithdrawalResponse>>>() {});
        return wrapper;
    }
}
