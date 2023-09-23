package br.com.mgsystems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.mgsystems.dao.IProdutoDAO;
import br.com.mgsystems.dao.ProdutoDAO;
import br.com.mgsystems.domain.Produto;

public class ProdutoTest {

	
	private IProdutoDAO produtoDAO;
	
	
	@Test
	public void cadastrarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("1030");
		produto.setNome("Xbox One");
		produto.setMarca("Microsoft");
		produto.setFornecedor("Kabum");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("1030");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getMarca(), produtoBD.getMarca());
		assertEquals(produto.getFornecedor(), produtoBD.getFornecedor());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("1030");
		produto.setNome("Xbox One");
		produto.setMarca("Microsoft");
		produto.setFornecedor("Kabum");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("1030");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getMarca(), produtoBD.getMarca());
		assertEquals(produto.getFornecedor(), produtoBD.getFornecedor());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("1030");
		produto.setNome("Xbox One");
		produto.setMarca("Microsoft");
		produto.setFornecedor("Kabum");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("1030");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getMarca(), produtoBD.getMarca());
		assertEquals(produto.getFornecedor(), produtoBD.getFornecedor());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("1030");
		produto.setNome("Xbox One");
		produto.setMarca("Microsoft");
		produto.setFornecedor("Kabum");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produto2 = new Produto();
		produto2.setCodigo("2040");
		produto2.setNome("Teste");
		produto2.setMarca("Teste Marca");
		produto2.setFornecedor("Teste Fornecedor");
		Integer countCad2 = produtoDAO.cadastrar(produto2);
		assertTrue(countCad2 == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int countDel = 0;
		for (Produto prod : list) {
			produtoDAO.excluir(prod);
			countDel++;
		}
		assertEquals(list.size(), countDel);
		
		list = produtoDAO.buscarTodos();
		assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void atualizarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("1030");
		produto.setNome("Xbox One");
		produto.setMarca("Microsoft");
		produto.setFornecedor("Kabum");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("1030");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getMarca(), produtoBD.getMarca());
		assertEquals(produto.getFornecedor(), produtoBD.getFornecedor());
		
		produtoBD.setCodigo("2040");
		produtoBD.setNome("Outro nome");
		Integer countUpdate = produtoDAO.atualizar(produtoBD);
		assertTrue(countUpdate == 1);
		
		Produto produtoBD1 = produtoDAO.buscar("1030");
		assertNull(produtoBD1);
		
		Produto produtoBD2 = produtoDAO.buscar("2040");
		assertNotNull(produtoBD2);
		assertEquals(produtoBD.getId(), produtoBD2.getId());
		assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
		assertEquals(produtoBD.getNome(), produtoBD2.getNome());
		
		List<Produto> list = produtoDAO.buscarTodos();
		for (Produto prod : list) {
			produtoDAO.excluir(prod);
		}
	}
}

