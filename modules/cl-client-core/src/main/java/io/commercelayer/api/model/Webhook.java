package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "webhooks"
)
public class Webhook extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList());

  private String topic;

  @Json(
      name = "callback_url"
  )
  private String callbackUrl;

  @Json(
      name = "include_resources"
  )
  private Object includeResources;

  public String getTopic() {
    return this.topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getCallbackUrl() {
    return this.callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public Object getIncludeResources() {
    return this.includeResources;
  }

  public void setIncludeResources(Object includeResources) {
    this.includeResources = includeResources;
  }
}
