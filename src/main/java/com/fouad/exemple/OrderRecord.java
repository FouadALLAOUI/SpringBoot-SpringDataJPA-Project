package com.fouad.exemple;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(String customerName, String productName, int quantity) {



}
