package me.dio.sacola.resource;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.resource.dto.ItemDto;
import me.dio.sacola.service.SacolaService;
import org.springframework.web.bind.annotation.*;

@Api(value = "/ifood.devweek/sacolas")
@RestController //Classe que contém os endpoints
@RequestMapping("/ifood.devweek/sacolas") //defini como vai ser escrito os endpoints
@RequiredArgsConstructor //necesssário por usar o private FINAL no sacola service, essa calsse pede um construtor para
                         //funcionar.

public class SacolaResource {
    private final SacolaService sacolaService;

    @PostMapping //post pq se necessita enviar informação
    public Item incluirItemNaSacola (@RequestBody ItemDto itemDto) { //o itemDto, vem do corpo da requisição, por isso se usao @ResquestBody
        return sacolaService.incluirItemNaSacola(itemDto);
    }

    @GetMapping("/{id}") //get pq necessita retorno de informação
    public Sacola verSacola(@PathVariable("id") Long id) {
        return sacolaService.verSacola(id);
    }

    @PatchMapping("/fecharSacola/{sacolaId}")  //metodo usado para atualizar um dado no Bd (Patch/Put)
    public Sacola fecharSacola(@PathVariable("sacolaId") Long sacolaId, @RequestParam("formaPagamento") int formaPagamento) {
        return sacolaService.fecharSacola(sacolaId, formaPagamento);
    }

}
