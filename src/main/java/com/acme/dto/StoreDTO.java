package com.acme.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDTO {
	@JsonIgnore
	private Long id;

	@NotNull(message = "Name cannot be null!")
	private String name;

	@NotNull(message = "Address cannot be null!")
	private String address;

	private StoreDTO() {
	}

	private StoreDTO(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public static StoreDTOBuilder newBuilder() {
		return new StoreDTOBuilder();
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public String getAddress() {
		return address;
	}

	public static class StoreDTOBuilder {
		private Long id;
		private String name;
		private String address;

		public StoreDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public StoreDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public StoreDTOBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public StoreDTO createStoreDTO() {
			return new StoreDTO(id, name, address);
		}
	}
}
