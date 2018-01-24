***REMOVED***
***REMOVED***
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
package org.brunocvcunha.coinpayments.requests.base;

***REMOVED***
import java.io.InputStream;

***REMOVED***
import org.brunocvcunha.coinpayments.CoinPayments;
import org.brunocvcunha.inutils4j.MyStreamUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@NoArgsConstructor
@Log4j
public abstract class CoinPaymentsRequest<T> {

    @Getter
    @Setter
    @JsonIgnore
    protected CoinPayments api;

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** @return the url
  ***REMOVED*****REMOVED*****REMOVED***/
    public abstract String getUrl();

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** @return the method
  ***REMOVED*****REMOVED*****REMOVED***/
    public abstract String getMethod();

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** @return the payload
  ***REMOVED*****REMOVED*****REMOVED***/
    public String getPayload() {
        return null;
***REMOVED***

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** @return the result
  ***REMOVED*****REMOVED*****REMOVED*** @throws IOException
  ***REMOVED*****REMOVED*****REMOVED*** @throws ClientProtocolException
  ***REMOVED*****REMOVED*****REMOVED***/
    public abstract T execute() throws ClientProtocolException, IOException;

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** Process response
  ***REMOVED*****REMOVED*****REMOVED*** 
  ***REMOVED*****REMOVED*****REMOVED*** @param resultCode
  ***REMOVED*****REMOVED*****REMOVED***            Status Code
  ***REMOVED*****REMOVED*****REMOVED*** @param content
  ***REMOVED*****REMOVED*****REMOVED***            Content
  ***REMOVED*****REMOVED*****REMOVED***/
    public abstract T parseResult(int resultCode, String content);

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** Parses Json into type
  ***REMOVED*****REMOVED*****REMOVED*** 
  ***REMOVED*****REMOVED*****REMOVED*** @param str
  ***REMOVED*****REMOVED*****REMOVED***            Entity content
  ***REMOVED*****REMOVED*****REMOVED*** @param clazz
  ***REMOVED*****REMOVED*****REMOVED***            Class
  ***REMOVED*****REMOVED*****REMOVED*** @return Result
  ***REMOVED*****REMOVED*****REMOVED***/
    @SneakyThrows
    public <U> U parseJson(String str, Class<U> clazz) {
        log.info("Reading " + clazz.getSimpleName() + " from " + str);
        return new ObjectMapper().readValue(str, clazz);
***REMOVED***
    
 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** Parses Json into type
  ***REMOVED*****REMOVED*****REMOVED*** 
  ***REMOVED*****REMOVED*****REMOVED*** @param str
  ***REMOVED*****REMOVED*****REMOVED***            Entity content
  ***REMOVED*****REMOVED*****REMOVED*** @param typeRef
  ***REMOVED*****REMOVED*****REMOVED***            TypeReference
  ***REMOVED*****REMOVED*****REMOVED*** @return Result
  ***REMOVED*****REMOVED*****REMOVED***/
    @SneakyThrows
    public <U> U parseJson(String str, TypeReference<T> type) {
        log.info("Reading " + type.getType() + " from " + str);
        return new ObjectMapper().readValue(str, type);
***REMOVED***

 ***REMOVED*****REMOVED*****REMOVED*****REMOVED***
  ***REMOVED*****REMOVED*****REMOVED*** Parses Json into type
  ***REMOVED*****REMOVED*****REMOVED*** 
  ***REMOVED*****REMOVED*****REMOVED*** @param is
  ***REMOVED*****REMOVED*****REMOVED***            Entity stream
  ***REMOVED*****REMOVED*****REMOVED*** @param clazz
  ***REMOVED*****REMOVED*****REMOVED***            Class
  ***REMOVED*****REMOVED*****REMOVED*** @return Result
  ***REMOVED*****REMOVED*****REMOVED***/
    @SneakyThrows
    public T parseJson(InputStream is, Class<T> clazz) {
        return this.parseJson(MyStreamUtils.readContent(is), clazz);
***REMOVED***

***REMOVED***
