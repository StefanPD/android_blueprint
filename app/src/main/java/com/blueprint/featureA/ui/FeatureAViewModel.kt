package com.blueprint.featureA.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blueprint.featureA.domain.FeatureARepository
import com.blueprint.featureA.domain.model.FeatureA
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    private val featureARepository: FeatureARepository,
) : ViewModel() {

    private val _features = MutableStateFlow(emptyList<FeatureA>())
    val features = _features.asStateFlow()


    fun getFeaturesA() {
        viewModelScope.launch {
            _features.value = featureARepository.getFeaturesA().getOrElse { emptyList() }
        }
    }

}