insert into users(id, nome, email, password) values (1, 'projuris', 'projuris@projuris.com', '');
insert into clientes(id, nome, email, endereco, telefone, created_at) values (1, 'marlon', 'marlon@marlon.com', 'cocal do sul', '48999998888', now());
insert into equipamentos(id, marca, tipo, created_at) values (1, 'Samsung', 'Celular', now())
insert into equipamentos(id, marca, tipo, created_at) values (2, 'Samsung', 'TV', now())
insert into ordens_servico(id, descricao, cliente_id, equipamento_id, ordem_status, created_at) values (1, 'Tela quebrada', 1, 1, 1, now());
insert into ordens_servico(id, descricao, cliente_id, equipamento_id, ordem_status, created_at, inicio_servico, final_servico) values (2, 'Ordem Finalizada', 1, 2, 1, now(), now(), now());