package com.socks.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Address{

	@JsonProperty("number")
	private String number;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private String street;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("userID")
	private String userID;
}