import styled from 'styled-components';
import { ClusterColorKey } from 'theme/theme';

export const List = styled.ul.attrs({ role: 'menu' })`
  & > & {
    padding: 0 0 0 8px;
  }

  & * {
    margin-bottom: 2px;
  }
`;

export const ClusterList = styled.ul.attrs<{ $colorKey: ClusterColorKey }>({
  role: 'menu',
})`
  border-radius: 8px;
  border: 1px solid
    ${({ theme, $colorKey }) => theme.clusterMenu.backgroundColor[$colorKey]};
  padding: 2px 4px;
  margin-bottom: 8px;
  background-color: ${({ theme, $colorKey }) =>
    theme.clusterMenu.backgroundColor[$colorKey]};
`;
