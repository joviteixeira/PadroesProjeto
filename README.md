Refatorando um Sistema de Sensores com Padrões GoF

 Visão Geral

 	Este projeto consiste na refatoração de um sistema legado para gerenciamento de sensores de uma linha de produção inteligente (IoT). O sistema original apresentava problemas de alto acoplamento e baixa coesão, dificultando sua manutenção e expansão.

 	Utilizando os padrões de projeto Criação e Estruturais do Gang of Four (GoF), a arquitetura foi modernizada para se tornar modular, flexível, reutilizável e de fácil manutenção, aderindo aos princípios de design orientado a objetos.

 Descrição dos Padrões Utilizados
 	Padrões de Criação
 	 	Singleton

 			Descrição: Garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a essa instância.

 			Aplicação: A classe SensorControlador foi implementada como um Singleton para assegurar que haja um único controlador central para todos os sensores, evitando conflitos e gerenciando os recursos de forma consistente.

 		Factory Method

 			Descrição: Define uma interface para criar um objeto, mas delega a responsabilidade de qual classe instanciar para uma classe "fábrica".

 			Aplicação: A SensorFactory foi criada para centralizar a lógica de criação dos sensores. Ela desacopla o SensorControlador das classes concretas dos sensores. Para adicionar um novo sensor, apenas a fábrica precisa ser modificada.


 	Padrões Estruturais
 	 	Adapter

 			Descrição: Permite que classes com interfaces incompatíveis trabalhem juntas.

 			Aplicação: As classes no pacote adaptacao (ex: TemperaturaAdaptada) servem como "tradutores". Elas envolvem as classes legadas e implementam a 	interface ISensor, permitindo que o código antigo seja utilizado no novo sistema sem qualquer modificação.

 		Decorator

 			Descrição: Adiciona novas funcionalidades a um objeto dinamicamente, "envelopando-o" em um ou mais decoradores.

 			Aplicação: As classes no pacote decoracao adicionam comportamentos de forma flexível:

 				- LogDecorator: Adiciona um log de console a cada leitura.

 				- AlertaDecorator: Verifica se o valor lido ultrapassa um limite pré-definido.

 				- FormatadorDecorator: Formata o dado bruto com sua unidade de medida (ex: "°C") para exibição.



Explicação sobre Ganhos de Coesão e Redução de Acoplamento

 	A refatoração trouxe ganhos significativos para a qualidade da arquitetura do software.

 	Redução de Acoplamento (Decoupling)

 		Antes: A classe SensorControlador era fortemente acoplada às implementações concretas dos sensores. Ela precisava conhecer cada classe  de sensor para poder instanciá-la e chamar seus métodos específicos.

 		Depois: O SensorControlador agora depende apenas da abstração ISensor e da SensorFactory. Ele não conhece mais os detalhes das classes TemperaturaAdaptada ou SensorTemperatura. Isso significa que novos sensores podem ser adicionados ao sistema sem que nenhuma linha de código no SensorControlador precise ser 	alterada.

 	Aumento da Coesão (Cohesion)

 		Antes: A classe SensorManager tinha baixa coesão, pois acumulava muitas responsabilidades: criar os sensores, ler os dados, formatar os valores e orquestrar a exibição.

 		Depois: As responsabilidades foram segregadas em classes distintas e coesas, seguindo o Princípio da Responsabilidade Única:

 			- Criação: Responsabilidade exclusiva da SensorFactory.

 			- Adaptação: Responsabilidade exclusiva das classes no pacote adaptacao.

 			- Funcionalidades Adicionais: Cada Decorator tem uma única responsabilidade (log, alerta ou formatação).

 			- Orquestração: O SensorControlador agora tem a única e coesa responsabilidade de gerenciar os sensores.




Instruções de Execução

 	Para compilar e executar o projeto, você precisará ter o JDK (Java Development Kit) instalado.

 		Estrutura de Arquivos: Garanta que seu projeto siga a estrutura de pastas que você criou.

 		Compilação (via linha de comando):

 				- Abra o terminal ou prompt de comando.

 				- Navegue até a pasta src do seu projeto.

 				cd /caminho/para/seu/projeto/src

 				- Execute o comando de compilação, que irá compilar todos os arquivos de todos os pacotes:

 				javac */*.java

 			Execução (via linha de comando):

 				- Ainda dentro da pasta src, execute o seguinte comando para iniciar o programa:

 				java main.Main

 			Execução (via IDE):

 				- Se estiver usando uma IDE como IntelliJ, Eclipse ou VS Code, basta abrir o projeto e executar o método main no arquivo Main.java.
