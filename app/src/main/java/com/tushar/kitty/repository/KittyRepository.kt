package com.tushar.kitty.repository

import com.tushar.kitty.api.KittyService
import javax.inject.Inject

class KittyRepository
@Inject
constructor(private val kittyService: KittyService) {
  suspend fun getCatList() = kittyService.getCatList()
}