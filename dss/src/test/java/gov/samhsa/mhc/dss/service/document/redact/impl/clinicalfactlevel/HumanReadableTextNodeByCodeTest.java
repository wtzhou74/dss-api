// TODO: 2/12/2016 Fix unit test
/*
package gov.samhsa.mhc.dss.service.document.redact.impl.clinicalfactlevel;

import static org.junit.Assert.assertEquals;

import gov.samhsa.acs.brms.domain.ClinicalFact;
import gov.samhsa.acs.brms.domain.FactModel;
import gov.samhsa.acs.brms.domain.RuleExecutionContainer;
import gov.samhsa.mhc.common.document.accessor.DocumentAccessor;
import gov.samhsa.mhc.common.document.accessor.DocumentAccessorImpl;
import gov.samhsa.mhc.common.document.converter.DocumentXmlConverter;
import gov.samhsa.mhc.common.document.converter.DocumentXmlConverterImpl;
import gov.samhsa.mhc.common.filereader.FileReader;
import gov.samhsa.mhc.common.filereader.FileReaderImpl;
import gov.samhsa.mhc.common.marshaller.SimpleMarshaller;
import gov.samhsa.mhc.common.marshaller.SimpleMarshallerImpl;
import gov.samhsa.mhc.common.marshaller.SimpleMarshallerException;
import gov.samhsa.mhc.dss.service.document.EmbeddedClinicalDocumentExtractor;
import gov.samhsa.mhc.dss.service.document.EmbeddedClinicalDocumentExtractorImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@RunWith(MockitoJUnitRunner.class)
public class HumanReadableTextNodeByCodeTest {

    public static final String TEST_PATH = "sampleC32-redactionHandlers/";
    public static final String FACTMODEL_PATH = "factmodel/";
    public static final String RULEEXECUTIONCONTAINER_PATH = "ruleexecutioncontainer/";

    private FileReader fileReader;
    private SimpleMarshaller marshaller;
    private DocumentAccessor documentAccessor;
    private DocumentXmlConverter documentXmlConverter;
    private EmbeddedClinicalDocumentExtractor embeddedClinicalDocumentExtractor;

    private HumanReadableTextNodeByCode sut;

    @Before
    public void setUp() throws Exception {
        fileReader = new FileReaderImpl();
        marshaller = new SimpleMarshallerImpl();
        documentAccessor = new DocumentAccessorImpl();
        documentXmlConverter = new DocumentXmlConverterImpl();
        embeddedClinicalDocumentExtractor = new EmbeddedClinicalDocumentExtractorImpl(documentXmlConverter, documentAccessor);
        sut = new HumanReadableTextNodeByCode(documentAccessor);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExecute() throws IOException, SimpleMarshallerException, XPathExpressionException {
        // Arrange
        String c32FileName = "MIE_SampleC32.xml";
        String factmodelXml = fileReader.readFile(TEST_PATH + FACTMODEL_PATH + c32FileName);
        String c32 = embeddedClinicalDocumentExtractor.extractClinicalDocumentFromFactModel(factmodelXml);
        String ruleExecutionContainerXml = fileReader.readFile(TEST_PATH + RULEEXECUTIONCONTAINER_PATH + c32FileName);
        RuleExecutionContainer ruleExecutionContainer = marshaller.unmarshalFromXml(RuleExecutionContainer.class, ruleExecutionContainerXml);
        Document c32Document = documentXmlConverter.loadDocument(c32);
        Document factModelDocument = documentXmlConverter.loadDocument(factmodelXml);
        FactModel factModel = marshaller.unmarshalFromXml(FactModel.class, factmodelXml);
        List<Node> listOfNodes = new LinkedList<Node>();
        Set<String> redactSectionCodesAndGeneratedEntryIds = new HashSet<String>();
        Set<String> redactSensitiveCategoryCodes = new HashSet<String>();
        ClinicalFact fact = factModel.getClinicalFactList().get(1);
        Set<String> valueSetCategories = new HashSet<String>();
        valueSetCategories.add("HIV");
        valueSetCategories.add("PSY");
        fact.setValueSetCategories(valueSetCategories);
        fact.setCode("HeArt");

        // Act
        sut.execute(c32Document, factModel.getXacmlResult(), factModel,
                factModelDocument, fact, ruleExecutionContainer, listOfNodes,
                redactSectionCodesAndGeneratedEntryIds,
                redactSensitiveCategoryCodes);

        // Assert
        assertEquals(1, listOfNodes.size());
        assertEquals(1, redactSectionCodesAndGeneratedEntryIds.size());
        assertEquals(1, redactSensitiveCategoryCodes.size());
        assertEquals(Node.TEXT_NODE, listOfNodes.get(0).getNodeType());
        assertEquals(" HEART RATE: 55bpm (2014-06-19 11:29:00)", listOfNodes.get(0).getNodeValue());
        assertEquals("d1e133", redactSectionCodesAndGeneratedEntryIds.toArray()[0]);
        assertEquals("HIV", redactSensitiveCategoryCodes.toArray()[0]);
    }
}
*/
