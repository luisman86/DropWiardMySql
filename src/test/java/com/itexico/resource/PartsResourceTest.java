package com.itexico.resource;

import com.itexico.model.Part;
import com.itexico.representation.Representation;
import com.itexico.services.PartsService;
import io.dropwizard.testing.junit.ResourceTestRule;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.ClassRule;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

public class PartsResourceTest {
    /*private static final String SUCCESS = "Success...";
    private static final String TEST_PART_NAME = "testPartName";
    private static final String TEST_PART_CODE = "testPartCode";
    private static final String PARTS_ENDPOINT = "/parts";

    private static final PartsService partsService = mock(PartsService.class);

    @Rule
    public static final ResourceTestRule resources =
            ResourceTestRule.builder().addResource(new PartsResource()).build();

    private final Part part = new Part(1, TEST_PART_NAME, TEST_PART_CODE);

    @Before
    public void setup() {
        when(partsService.getPart(eq(1))).thenReturn(part);
        List<Part> parts = new ArrayList<>();
        parts.add(part);
        when(partsService.getParts()).thenReturn(parts);
        when(partsService.createPart(any(Part.class))).thenReturn(part);
        when(partsService.editPart(any(Part.class))).thenReturn(part);
        when(partsService.deletePart(eq(1))).thenReturn(SUCCESS);
    }

    @Test
    public void testGetPart() {
        Part partResponse = resources.target(PARTS_ENDPOINT + "/1").request()
                .get(TestPartRepresentation.class).getData();
        assertThat(partResponse.getId()).isEqualTo(part.getId());
        assertThat(partResponse.getName()).isEqualTo(part.getName());
        assertThat(partResponse.getCode()).isEqualTo(part.getCode());
        verify(partsService).getPart(1);
    }

    @Test
    public void testGetParts() {
        List<Part> parts =
                resources.target(PARTS_ENDPOINT).request().get(TestPartsRepresentation.class).getData();
        assertThat(parts.size()).isEqualTo(1);
        assertThat(parts.get(0).getId()).isEqualTo(part.getId());
        assertThat(parts.get(0).getName()).isEqualTo(part.getName());
        assertThat(parts.get(0).getCode()).isEqualTo(part.getCode());
        verify(partsService).getParts();
    }

    @Test
    public void testCreatePart() {
        Part newPart = resources.target(PARTS_ENDPOINT).request()
                .post(Entity.entity(part, MediaType.APPLICATION_JSON_TYPE), TestPartRepresentation.class)
                .getData();
        assertNotNull(newPart);
        assertThat(newPart.getId()).isEqualTo(part.getId());
        assertThat(newPart.getName()).isEqualTo(part.getName());
        assertThat(newPart.getCode()).isEqualTo(part.getCode());
        verify(partsService).createPart(any(Part.class));
    }

    @Test
    public void testEditPart() {
        Part editedPart = resources.target(PARTS_ENDPOINT + "/1").request()
                .put(Entity.entity(part, MediaType.APPLICATION_JSON_TYPE), TestPartRepresentation.class)
                .getData();
        assertNotNull(editedPart);
        assertThat(editedPart.getId()).isEqualTo(part.getId());
        assertThat(editedPart.getName()).isEqualTo(part.getName());
        assertThat(editedPart.getCode()).isEqualTo(part.getCode());
        verify(partsService).editPart(any(Part.class));
    }

    @Test
    public void testDeletePart() {
        resources.target("/parts");
        assertThat(resources.target(PARTS_ENDPOINT + "/1").request()
                .delete(TestDeleteRepresentation.class).getData()).isEqualTo(SUCCESS);
        verify(partsService).deletePart(1);
    }

    private static class TestPartRepresentation extends Representation<Part> {

    }

    private static class TestPartsRepresentation extends Representation<List<Part>> {

    }

    private static class TestDeleteRepresentation extends Representation<String> {

    }*/
}