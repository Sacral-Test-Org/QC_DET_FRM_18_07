package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.InsuranceCoverController;
import com.azbj.qc.det.frm.model.Nominee;
import com.azbj.qc.det.frm.service.NomineeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class NomineeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NomineeService nomineeService;

    @InjectMocks
    private InsuranceCoverController insuranceCoverController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(insuranceCoverController).build();
    }

    @Test
    public void testAddNominee() throws Exception {
        Nominee nominee = new Nominee();
        nominee.setContractId(1);
        nominee.setVersionNo(1);
        nominee.setObjectId(1);
        nominee.setActionCode("ADD");
        nominee.setTopIndicator('Y');
        nominee.setPartitionNo(1);
        nominee.setCoverCode("COV001");
        nominee.setCoverNo(1);

        when(nomineeService.addNominee(any(Nominee.class))).thenReturn(nominee);

        mockMvc.perform(post("/api/nominee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"contractId\":1,\"versionNo\":1,\"objectId\":1,\"actionCode\":\"ADD\",\"topIndicator\":\"Y\",\"partitionNo\":1,\"coverCode\":\"COV001\",\"coverNo\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractId").value(1))
                .andExpect(jsonPath("$.versionNo").value(1))
                .andExpect(jsonPath("$.objectId").value(1))
                .andExpect(jsonPath("$.actionCode").value("ADD"))
                .andExpect(jsonPath("$.topIndicator").value("Y"))
                .andExpect(jsonPath("$.partitionNo").value(1))
                .andExpect(jsonPath("$.coverCode").value("COV001"))
                .andExpect(jsonPath("$.coverNo").value(1));
    }

    @Test
    public void testUpdateNominee() throws Exception {
        Nominee nominee = new Nominee();
        nominee.setContractId(1);
        nominee.setVersionNo(1);
        nominee.setObjectId(1);
        nominee.setActionCode("UPDATE");
        nominee.setTopIndicator('Y');
        nominee.setPartitionNo(1);
        nominee.setCoverCode("COV001");
        nominee.setCoverNo(1);

        when(nomineeService.updateNominee(any(Nominee.class))).thenReturn(nominee);

        mockMvc.perform(put("/api/nominee")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"contractId\":1,\"versionNo\":1,\"objectId\":1,\"actionCode\":\"UPDATE\",\"topIndicator\":\"Y\",\"partitionNo\":1,\"coverCode\":\"COV001\",\"coverNo\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractId").value(1))
                .andExpect(jsonPath("$.versionNo").value(1))
                .andExpect(jsonPath("$.objectId").value(1))
                .andExpect(jsonPath("$.actionCode").value("UPDATE"))
                .andExpect(jsonPath("$.topIndicator").value("Y"))
                .andExpect(jsonPath("$.partitionNo").value(1))
                .andExpect(jsonPath("$.coverCode").value("COV001"))
                .andExpect(jsonPath("$.coverNo").value(1));
    }

    @Test
    public void testGetNominee() throws Exception {
        Nominee nominee = new Nominee();
        nominee.setContractId(1);
        nominee.setVersionNo(1);
        nominee.setObjectId(1);
        nominee.setActionCode("GET");
        nominee.setTopIndicator('Y');
        nominee.setPartitionNo(1);
        nominee.setCoverCode("COV001");
        nominee.setCoverNo(1);

        when(nomineeService.getNominee(1, 1)).thenReturn(nominee);

        mockMvc.perform(get("/api/nominee/1/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractId").value(1))
                .andExpect(jsonPath("$.versionNo").value(1))
                .andExpect(jsonPath("$.objectId").value(1))
                .andExpect(jsonPath("$.actionCode").value("GET"))
                .andExpect(jsonPath("$.topIndicator").value("Y"))
                .andExpect(jsonPath("$.partitionNo").value(1))
                .andExpect(jsonPath("$.coverCode").value("COV001"))
                .andExpect(jsonPath("$.coverNo").value(1));
    }
}
