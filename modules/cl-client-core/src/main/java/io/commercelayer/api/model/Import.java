package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "imports"
)
public class Import extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList());

  @Json(
      name = "resource_type"
  )
  private String resourceType;

  @Json(
      name = "parent_resource_id"
  )
  private Integer parentResourceId;

  private Object inputs;

  @Json(
      name = "cleanup_records"
  )
  private Boolean cleanupRecords;

  private String status;

  @Json(
      name = "started_at"
  )
  private String startedAt;

  @Json(
      name = "completed_at"
  )
  private String completedAt;

  @Json(
      name = "errors_count"
  )
  private Integer errorsCount;

  @Json(
      name = "warnings_count"
  )
  private Integer warningsCount;

  @Json(
      name = "destroyed_count"
  )
  private Integer destroyedCount;

  @Json(
      name = "errors_log"
  )
  private Object errorsLog;

  @Json(
      name = "warnings_log"
  )
  private Object warningsLog;

  public String getResourceType() {
    return this.resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public Integer getParentResourceId() {
    return this.parentResourceId;
  }

  public void setParentResourceId(Integer parentResourceId) {
    this.parentResourceId = parentResourceId;
  }

  public Object getInputs() {
    return this.inputs;
  }

  public void setInputs(Object inputs) {
    this.inputs = inputs;
  }

  public Boolean getCleanupRecords() {
    return this.cleanupRecords;
  }

  public void setCleanupRecords(Boolean cleanupRecords) {
    this.cleanupRecords = cleanupRecords;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStartedAt() {
    return this.startedAt;
  }

  public void setStartedAt(String startedAt) {
    this.startedAt = startedAt;
  }

  public String getCompletedAt() {
    return this.completedAt;
  }

  public void setCompletedAt(String completedAt) {
    this.completedAt = completedAt;
  }

  public Integer getErrorsCount() {
    return this.errorsCount;
  }

  public void setErrorsCount(Integer errorsCount) {
    this.errorsCount = errorsCount;
  }

  public Integer getWarningsCount() {
    return this.warningsCount;
  }

  public void setWarningsCount(Integer warningsCount) {
    this.warningsCount = warningsCount;
  }

  public Integer getDestroyedCount() {
    return this.destroyedCount;
  }

  public void setDestroyedCount(Integer destroyedCount) {
    this.destroyedCount = destroyedCount;
  }

  public Object getErrorsLog() {
    return this.errorsLog;
  }

  public void setErrorsLog(Object errorsLog) {
    this.errorsLog = errorsLog;
  }

  public Object getWarningsLog() {
    return this.warningsLog;
  }

  public void setWarningsLog(Object warningsLog) {
    this.warningsLog = warningsLog;
  }
}
