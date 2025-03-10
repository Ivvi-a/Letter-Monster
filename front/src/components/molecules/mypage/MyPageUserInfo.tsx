import { useCallback, useState } from "react";
import { usePostNickname } from "../../../hooks/user/usePostNickname";
import styles from "./MyPageMolecules.module.scss";
import { useGetUserNickname } from "../../../hooks/user/useGetUserNickName";
import { useDeleteUser } from "../../../hooks/user/useDeleteUser";
import { useAlert } from "../../../hooks/notice/useAlert";
import DefaultButton from "../../atoms/button/DefaultButton";
import Modal from "../../atoms/modal/Modal";
import { useTranslation } from "react-i18next";

function MyPageUserInfo() {
  const { t } = useTranslation();
  const deleteUser = useDeleteUser();
  const { showAlert } = useAlert();
  const changeNickname = usePostNickname();
  const [nickname, setNickname] = useState("");
  const { data: userInfo } = useGetUserNickname();

  const handleUserNicknameChange = useCallback(
    (event: React.ChangeEvent<HTMLInputElement>) => {
      const newNickname = event.target.value;
      if (newNickname.startsWith(" ")) {
        showAlert(t("notification.nameblank"));
      } else if (
        // /[^a-zA-Z0-9ㄱ-힣ㆍᆞᆢ\s]/.test(newNickname) ||
        newNickname.includes("　")
      ) {
        showAlert(t("notification.nameblank"));
      } else if (newNickname.length > 10) {
        showAlert(t("notification.name10"));
      } else {
        setNickname(newNickname);
      }
    },
    []
  );

  const postNicknameMutation = () => {
    if (nickname.length < 2) {
      showAlert(t("mypage.nicknameTwo"));
    } else {
      changeNickname.mutate(nickname, {
        onSuccess: () => {
          showAlert(t("mypage.nicknameChangeSuccess"));
        },
        onError: (err: any) => {
          if (err.response.data.status == 400) {
            showAlert(t("mypage.nicknameNobadwords"));
          } else {
            showAlert(t("notification.retry"));
          }
        },
      });
    }
  };

  const handleKeyDown = (event: React.KeyboardEvent<HTMLInputElement>) => {
    if (event.key === "Enter") {
      postNicknameMutation();
    }
  };

  type ModalName = "leaveServiceAlert" | "deleteAlert";

  const [isModalOpen, setModalOpen] = useState({
    leaveServiceAlert: false,
    deleteAlert: false,
  });

  const handleToggleModal = (modalName: ModalName) => {
    setModalOpen((prevState) => ({
      ...prevState,
      [modalName]: !prevState[modalName],
    }));
  };

  return (
    <>
      <div className={styles.userInfoContainer}>
        <div className={styles.userInfoDetail}>
          <div>
            <div>{t("mypage.nickname")}</div>
            <div>{t("mypage.nicknameTag")}</div>
          </div>
          <div className={styles.userInfoReal}>
            {userInfo && <div>{userInfo?.nickname}</div>}
            {userInfo && <div>{userInfo?.nicknameTag}</div>}
          </div>
        </div>
        <input
          value={nickname}
          className={styles.userNicknameInput}
          type="text"
          onChange={handleUserNicknameChange}
          onKeyDown={handleKeyDown}
          placeholder={`${t("mypage.nickname")}`}
        />
        <button
          className={styles.userNicknameChangeCheck}
          onClick={() => postNicknameMutation()}
        >
          {t("mypage.nicknameChange")}
        </button>
        <button
          className={styles.userLeaveCheck}
          onClick={() => handleToggleModal("deleteAlert")}
        >
          {t("myUserInfo.leaveButton")}
        </button>
      </div>
      {isModalOpen.deleteAlert && (
        <Modal
          isOpen={isModalOpen.deleteAlert}
          onClose={() => handleToggleModal("deleteAlert")}
        >
          <div className={styles.buttonBox}>
            {t("myUserInfo.leaveCheck")}
            <DefaultButton onClick={() => deleteUser()}>
              {t("myUserInfo.leaveService")}
            </DefaultButton>
            <DefaultButton
              onClick={() => {
                handleToggleModal("deleteAlert");
              }}
            >
              {t("sketchbook.cancel")}
            </DefaultButton>
          </div>
        </Modal>
      )}
    </>
  );
}

export default MyPageUserInfo;
