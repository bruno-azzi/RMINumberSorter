# RMINumberSorter

Construa uma aplicação paralela e distribuída que permita a ordenação de grandes conjuntos de valores
numéricos. O problema base consiste na ordenação de 10 conjuntos compostos por 10.000 valores
numéricos inteiros posicionados aleatoriamente no conjunto. Para ordenação, utilize um algoritmo com
complexidade de tempo para caso médio igual a 𝑂(𝑛 .2)

Observe o esquema gráfico e implemente sua arquitetura com base no mesmo. Assuma que o retângulo
Server e os círculos Worker representam processos que comunicam-se, coordenando suas ações.
Somente os Workers ordenarão conjuntos, enquanto Server fará o controle com relação aos trabalhos
por executar e os já executados, guardando seus resultados e aguardando a conclusão de todos.
