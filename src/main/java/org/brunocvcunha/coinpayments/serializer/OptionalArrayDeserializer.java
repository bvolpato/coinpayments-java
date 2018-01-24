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
package org.brunocvcunha.coinpayments.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

***REMOVED***
import java.util.ArrayList;
import java.util.List;

public abstract class OptionalArrayDeserializer<T> extends JsonDeserializer<List<T>> {

    private final Class<T> clazz;

    public OptionalArrayDeserializer(Class<T> clazz) {
        this.clazz = clazz;
***REMOVED***

    @Override
    public List<T> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        ArrayList<T> list = new ArrayList<>();
        if (node.isArray()) {
            for (JsonNode elementNode : node) {
                list.add(oc.treeToValue(elementNode, clazz));
***REMOVED***
***REMOVED*** else {
            list.add(oc.treeToValue(node, clazz));
***REMOVED***
        return list;
***REMOVED***
***REMOVED***