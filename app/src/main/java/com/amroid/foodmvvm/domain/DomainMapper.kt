package com.amroid.foodmvvm.domain

interface DomainMapper<T,DomainModel> {
  fun mapFromDomainModel(domainModel: DomainModel):T
  fun mapToDomainModel(model:T):DomainModel
}