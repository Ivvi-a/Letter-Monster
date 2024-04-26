import { useMutation, useQueryClient } from "@tanstack/react-query";
import {
  cancelCharacter,
  deleteCharacter,
  patchCharacterNickname,
  patchMainCharacter,
} from "../../api/Api";

/** 캐릭터 닉네임 설정 */
export function usePatchCharacterNickname() {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: ({
      characterId,
      nickname,
    }: {
      characterId: number;
      nickname: string;
    }) => patchCharacterNickname(characterId, nickname),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["Character"] });
    },
  });
}

/** 대표 캐릭터 선정 */
export function useSelectMainCharacter() {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (characterId: number) => patchMainCharacter(characterId),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["userCharacterList"] });
    },
  });
}

/** 캐릭터 생성 취소 */
export function useCancelCharacter(characterId: number) {
  return () => {
    cancelCharacter(characterId);
  };
}

/** 캐릭터 삭제 */
export function useDeleteCharacter() {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (characterId: number) => deleteCharacter(characterId),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["Character"] });
    },
  });
}
