package com.umesh.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberConverterTest extends RomanApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@DisplayName("Convert 1 to Roman numeral")
	public void convert1() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToRomanApi(1);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "I");

	}

	@Test
	@DisplayName("Convert 4 to Roman numeral")
	public void convert4() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(4);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "IV");
	}

	@Test
	@DisplayName("Convert 9 to Roman numeral")
	public void convert9() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(9);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "IX");
	}

	@Test
	@DisplayName("Convert 90 to Roman numeral")
	public void convert90() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(90);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "XC");
	}

	@Test
	@DisplayName("Convert 900 to Roman numeral")
	public void convert900() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(900);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "CM");
	}

	@Test
	@DisplayName("Convert 1903 to Roman numeral")
	public void convert1903() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(1903);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "MCMIII");
	}

	@Test
	@DisplayName("Convert 1997 to Roman numeral")
	public void convert1997() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(1997);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "MCMXCVII");
	}

	@Test
	@DisplayName("Convert 4000 to Roman numeral")
	public void convert4000() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(4000);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "M(V)");
	}

	@Test
	@DisplayName("Number 0 should throw exception -Invalid number")
	public void convert0() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(0);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Invalid number");
	}

	@Test
	@DisplayName("Number -1 should throw exception -Invalid number")
	public void convertnegative() throws Exception {
		MvcResult mvcResult = callConvertToRomanApi(-1);
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Invalid number");
	}

	private MvcResult callConvertToRomanApi(int number) throws Exception {
		String uri = String.format("/convert-to-roman/%d", number);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		return mvcResult;
	}
	
	@Test
	@DisplayName("Convert I to number")
	public void convertI() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("I");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "1");

	}
	@Test
	@DisplayName("Convert IV to number")
	public void convertIV() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("IV");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "4");

	}
	@Test
	@DisplayName("Convert IX to number")
	public void convertIX() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("IX");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "9");

	}
	@Test
	@DisplayName("Convert XC to number")
	public void convertXC() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("XC");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "90");

	}
	@Test
	@DisplayName("Convert CM to number")
	public void convertCM() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("CM");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "900");

	}
	@Test
	@DisplayName("Convert MCMIII to number")
	public void convertMCMIII() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("MCMIII");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "1903");

	}
	@Test
	@DisplayName("Convert MCMXCVII to number")
	public void convertMCMXCVII() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("MCMXCVII");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "1997");

	}
	@Test
	@DisplayName("Convert M(V) to number")
	public void convertMV() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("M(V)");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "4000");

	}
	@Test
	@DisplayName("Invalid roman numeral should throw exception")
	public void invalidRoman() throws Exception {
		// 1
		MvcResult mvcResult = callConvertToNumberApi("IIIII");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Invalid Roman numeral");

	}
	
	private MvcResult callConvertToNumberApi(String roman) throws Exception {
		String uri = String.format("/convert-to-number/%s", roman);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		return mvcResult;
	}

}
