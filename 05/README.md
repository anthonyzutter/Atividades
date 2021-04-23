# Avaliação
### I - Dados de Entrada do programa:
* Nome Completo;
* Data de Nascimento;
* Valor do benefício
* Tempo do benefício em meses
* Categoria (Empregado, Empregador ou Desempregado)
	* Empregado
		* Solicitar se é aposentado
	* Empregador
		* Solicitar quantos funcionários
	* Desempregado
		* Há quantos meses está desempregado
* Estado (UF)
### II - Regras de negócio Gerais: 
1. Empregados receberão entre R$ 1.000 e R$ 1.800
2. Empregadores receberão R$ 200,00 por funcionário
3. Desempregados receberão entre R$ 1.500 e R$ 2.300
4. O benefício será de no máximo 12 meses e mínimo 2 meses
5. Ao final de cada execução o programa deverá perguntar se o usuário deseja informar um novo beneficiário ou não

### III - Regras de negócio Específicas

* A - O benefício só será concedido para maiores de 18 anos
* N -  O benefício de pessoas que moram em Santa Catarina terá acréscimo de 5%
* T - O benefício de pessoas que moram no Pará terá acréscimo de 9%
* H - Se estiver desempregado há menos de 6 meses terá uma redução de 10%
* O - O Benefício será de 7 meses para empregadores
* Y - O Benefício será de 5 meses para empregados com mais de 50 anos

### IV - Ao final de cada execução deverá ser impresso os seguintes dados
* Nome Completo, Data de Nascimento, Categoria, Quais regras foram atendidas (Ex: Usuário é maior de idade, usuário é aposentado então terá um acréscimo de X), por quanto tempo o usuário receberá o benefício e valor do benefício

### V - Ao final da execução do programa
* Total de usuários lidos;
* Total de beneficiários;
* Total de valor que será concedido;
* O nome dos 2 beneficiários que irão receber os maiores valor de todos;
* O nome dos 2 beneficiários que irão receber os benefícios por mais tempo.
