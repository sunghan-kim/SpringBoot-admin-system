package com.example.study.ifs;

import com.example.study.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Req request); // TODO: Request Object 추가

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);

}
