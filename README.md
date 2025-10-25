# 📊 Steam Data Analyzer - Processador de Dados de Jogos

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

Sistema Java para análise e processamento de dados da plataforma Steam, permitindo filtragem por período e geração de relatórios personalizados.

## 📋 Descrição

Aplicação que processa o dataset SteamCharts.csv (83k+ registros) para filtrar jogos por ano, mês e média de jogadores ativos, com opções de exibição em console e geração de arquivos CSV.

## 🏗️ Arquitetura do Sistema

```
📦 Steam Data Analyzer
├── 🎨 View (Principal)
├── ⚙️ Controller (SteamController)
└── 📁 Model (Data Processing)
```

## 📁 Estrutura do Projeto

```
src/
├── controller/
│   └── SteamController.java    # Lógica de processamento
└── view/
    └── Principal.java          # Interface principal
```

## 🎯 Funcionalidades

### ✅ **Filtragem e Exibição em Console**
- Filtra jogos por ano, mês e média mínima de jogadores
- Exibe resultados em formato tabular organizado
- Formatação profissional com alinhamento

### ✅ **Geração de Arquivos CSV**
- Cria arquivos filtrados por período específico
- Valida existência do diretório de destino
- Formato padronizado: `nome do jogo;média de jogadores`

### ✅ **Processamento Eficiente**
- Manipulação de dataset com 83k+ registros
- Leitura bufferizada para otimização de performance
- Tratamento robusto de exceções

## 🔧 Implementação

### **Classe SteamController**
```java
public class SteamController {
    // Métodos principais:
    public void readGames(String year, String month, double mean)
    public void createCSV(String year, String month, String path, String name, String extension)
    private String readYearMonth(String year, String month)
    private void printLogic(String[] game, String year, String month, double mean)
}
```

## 🚀 Como Executar

### **Compilação**
```bash
javac -d bin src/controller/*.java src/view/*.java
```

### **Execução**
```bash
java -cp bin view.Principal
```

## 📊 Exemplo de Saída

### **Console:**
```
=========================================================================
NOME_JOGO                                      MEDIA_JOGADORES_ATIVOS
=========================================================================
Counter-Strike: Global Offensive              85642.85
Dota 2                                        73421.92
PUBG: BATTLEGROUNDS                           15234.67
```

### **Arquivo CSV Gerado:**
```csv
NOME DO JOGO;MEDIA DE JOGADORES ATIVOS
Counter-Strike: Global Offensive;85642.85
Dota 2;73421.92
PUBG: BATTLEGROUNDS;15234.67
```

## ⚙️ Características Técnicas

- **📈 Processamento de Grande Volume**: 83k+ registros eficientemente
- **🎯 Filtros Múltiplos**: Ano, mês e média mínima
- **💾 Geração de Arquivos**: CSV com dados filtrados
- **🛡️ Validação Robusta**: Diretórios e arquivos
- **📐 Formatação Profissional**: Saída alinhada e organizada

## 💡 Casos de Uso

### **Análise de Popularidade**
```java
// Jogos com média > 7000 em Janeiro/2017
steamReading.readGames("2017", "January", 7000.0);
```

### **Exportação de Dados**
```java
// Gera CSV com jogos de Março/2018
steamReading.createCSV("2018", "March", "/output/", "relatorio", ".csv");
```

### **Business Intelligence**
- Identificação de tendências sazonais
- Análise de performance de jogos
- Geração de relatórios para publishers

## 🎯 Tecnologias Utilizadas

- **Java SE**
- **Manipulação de Arquivos CSV**
- **Streams e Bufferização**
- **Formatação de Saída**
- **Gerenciamento de Diretórios**

## 🔄 Fluxo de Processamento

1. **Leitura do Dataset** → SteamCharts.csv
2. **Aplicação de Filtros** → Ano, Mês, Média
3. **Saída** → Console ou Arquivo CSV
4. **Validação** → Diretórios e permissões

## 👨‍💻 Autor

**Gabriel** - [GabrielGit10110](https://github.com/GabrielGit10110)

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

<div align="center">

**Transformando dados da Steam em insights acionáveis!** 🎮📈

</div>
