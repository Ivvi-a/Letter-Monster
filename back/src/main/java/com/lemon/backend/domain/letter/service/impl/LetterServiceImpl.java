package com.lemon.backend.domain.letter.service.impl;

import com.lemon.backend.domain.characters.entity.Characters;
import com.lemon.backend.domain.characters.repository.CharacterRepository;
import com.lemon.backend.domain.letter.dto.requestDto.LetterGetListDto;
import com.lemon.backend.domain.letter.dto.responseDto.LetterCreateDto;
import com.lemon.backend.domain.letter.entity.Letter;
import com.lemon.backend.domain.letter.repository.LetterRepository;
import com.lemon.backend.domain.letter.service.LetterService;
import com.lemon.backend.domain.sketchbook.entity.Sketchbook;
import com.lemon.backend.domain.sketchbook.repository.SketchbookRepository;
import com.lemon.backend.global.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class LetterServiceImpl implements LetterService {

    private final CharacterRepository characterRepository;
    private final SketchbookRepository sketchbookRepository;
    private final LetterRepository letterRepository;

    @Override
    public List<LetterGetListDto> getLetterList(Long sketchbookId){
        return letterRepository.getLetterList(sketchbookId).orElseThrow();
    }

    @Transactional
    @Override
    public Long createLetter(LetterCreateDto letterDto){
        Characters character = characterRepository.findById(letterDto.getCharactersId()).orElseThrow();
        Sketchbook sketchbook = sketchbookRepository.findById(letterDto.getSketchbookId()).orElseThrow();

        Letter letter = Letter.builder()
                .sender(letterDto.getSender())
                .receiver(letterDto.getReceiver())
                .content(letterDto.getContent())
                .characters(character)
                .sketchbook(sketchbook)
                .build();
        return letterRepository.save(letter).getId();
    }

    @Transactional
    @Override
    public void deleteLetter(Long letterId){
        letterRepository.deleteById(letterId);
    }
}
