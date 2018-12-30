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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProfileInfoResponse {

    private String pbntag;

    private String merchant;

    @JsonProperty("profile_name")
    private String profileName;

    @JsonProperty("profile_url")
    private String profileUrl;

    @JsonProperty("profile_email")
    private String profileEmail;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("member_since")
    private long memberSince;

    private List<String> feedback;

}
