/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.bot.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.linecorp.bot.model.content.AbstractContent;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;

@ToString
@Getter
public class SendingMultipleMessagesRequestContent {
    /**
     * Optional. Zero-based index of the message to be notified. Default value is 0.
     */
    private final int messageNotified;

    /**
     * The messages property is an array with multiple sent message definitions.
     */
    private final Collection<AbstractContent> messages;

    @JsonCreator
    public SendingMultipleMessagesRequestContent(
            @JsonProperty("messageNotified") int messageNotified,
            @JsonProperty("contents") Collection<AbstractContent> contents) {
        this.messages = contents;
        this.messageNotified = messageNotified;
    }

    public SendingMultipleMessagesRequestContent(Collection<AbstractContent> contents) {
        this(0, contents);
    }
}
