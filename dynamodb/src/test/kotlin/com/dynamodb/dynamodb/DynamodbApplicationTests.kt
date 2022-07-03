package com.dynamodb.dynamodb

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest
class DynamodbApplicationTests {

	@Test
	fun contextLoads() {
	}

	var testRestTemplate = TestRestTemplate()

	@TestConfiguration
	internal class ControllerTestConfig {
	}

	private fun applicationUrl() = "http://localhost:8080/change/"

	@Test
	fun testGetChangeFrom100() {
		val url = applicationUrl()
		val requestJson = "{\"amount\":100}"
		val headers = HttpHeaders()
		headers.contentType = MediaType.APPLICATION_JSON

		val entity = HttpEntity(requestJson, headers)
		val result = testRestTemplate.postForEntity(url, entity, String::class.java)
		Assertions.assertEquals(HttpStatus.OK, result.statusCode)
		Assertions.assertEquals("{\"change\":\"2 x R50\"}", result.body)
	}

	@Test
	fun testGetChangeFrom50() {
		val url = applicationUrl()
		val requestJson = "{\"amount\":50}"
		val headers = HttpHeaders()
		headers.contentType = MediaType.APPLICATION_JSON

		val entity = HttpEntity(requestJson, headers)
		val result = testRestTemplate.postForEntity(url, entity, String::class.java)
		Assertions.assertEquals(HttpStatus.OK, result.statusCode)
		Assertions.assertEquals("{\"change\":\"2 x R20 + 1 x R10\"}", result.body)
	}

	@Test
	fun testGetChangeFrom30() {
		val url = applicationUrl()
		val requestJson = "{\"amount\":30}"
		val headers = HttpHeaders()
		headers.contentType = MediaType.APPLICATION_JSON

		val entity = HttpEntity(requestJson, headers)
		val result = testRestTemplate.postForEntity(url, entity, String::class.java)
		Assertions.assertEquals(HttpStatus.OK, result.statusCode)
		Assertions.assertEquals("{\"change\":\"1 x R20 + 1 x R10\"}", result.body)
	}

	@Test
	fun testGetChangeFrom30_50() {
		val url = applicationUrl()
		val requestJson = "{\"amount\":30.50}"
		val headers = HttpHeaders()
		headers.contentType = MediaType.APPLICATION_JSON

		val entity = HttpEntity(requestJson, headers)
		val result = testRestTemplate.postForEntity(url, entity, String::class.java)
		Assertions.assertEquals(HttpStatus.OK, result.statusCode)
		Assertions.assertEquals("{\"change\":\"2 x 20c + 1 x 10c + 1 x R20 + 1 x R10\"}", result.body)
	}



}
