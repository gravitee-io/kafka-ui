import React from 'react';
import Logo from 'components/common/Logo/Logo';
import { Button } from 'components/common/Button/Button';
import MenuIcon from 'components/common/Icons/MenuIcon';

import { UserTimezone } from './UserTimezone/UserTimezone';
import UserInfo from './UserInfo/UserInfo';
import * as S from './NavBar.styled';

interface Props {
  onBurgerClick: () => void;
}

export type ThemeDropDownValue = 'auto_theme' | 'light_theme' | 'dark_theme';

const NavBar: React.FC<Props> = ({ onBurgerClick }) => {
  return (
    <S.Navbar role="navigation" aria-label="Page Header">
      <S.NavbarBrand>
        <S.NavbarBrand>
          <Button buttonType="text" buttonSize="S" onClick={onBurgerClick}>
            <MenuIcon />
          </Button>
          <S.Hyperlink to="/">
            <Logo />
            Kafka Console
          </S.Hyperlink>
        </S.NavbarBrand>
      </S.NavbarBrand>
      <S.NavbarSocial>
        <UserTimezone />
        <UserInfo />
      </S.NavbarSocial>
    </S.Navbar>
  );
};

export default NavBar;
