export const getItemInStorage = (key) => {
  return localStorage.getItem(key);
};

export const saveItemInStorage = (key, value) => {
  localStorage.setItem(key, value);
};

export const removeItemInStorage = (key) => {
  localStorage.removeItem(key);
};
