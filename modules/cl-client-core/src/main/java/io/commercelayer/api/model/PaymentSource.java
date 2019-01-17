package io.commercelayer.api.model;

import io.commercelayer.api.model.common.ApiResource;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
	    type = "payment_sources"
	)
public class PaymentSource extends ApiResource {

	private static final long serialVersionUID = 4849844764713705863L;

}
